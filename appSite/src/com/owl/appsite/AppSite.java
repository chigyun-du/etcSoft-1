package com.owl.appsite;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AppSite extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        // alpha, scale animation ����

        ImageView image = (ImageView) findViewById(R.id.img_app_mark);
        Animation alphaAnim = AnimationUtils.loadAnimation(this, R.anim.tween);
        image.startAnimation(alphaAnim);

        // frame animation

//        ImageView img = (ImageView) findViewById(R.id.anim_bg);
//        img.setBackgroundResource(R.drawable.anim_list);
//
//        AnimationDrawable fromAnimation = (AnimationDrawable) img.getBackground();
//        fromAnimation.start();

        // �� �ڵ�� �Ʒ� �ڵ� �������� ���µ�?
        // ���� �ڵ尡 �� ������...

        ImageView img = (ImageView) findViewById(R.id.anim_bg);
        img.setBackgroundResource(R.drawable.anim_list);

        SlideStart slideStart = new SlideStart();
        SlideEnd slideEnd = new SlideEnd();

        Timer startTimer = new Timer(false);
        startTimer.schedule(slideStart, 1000);
        // 1�ʸ��� ����Ǹ� fromAnimation.start(); �� �κ���
        // �ݺ� ȣ��Ǵµ�, �̻��� ����?

        Timer endTimer = new Timer(false);
        endTimer.schedule(slideEnd, 10000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_app_site, menu);
        return true;
    }

    class SlideStart extends TimerTask {

        @Override
        public void run() {
            ImageView img = (ImageView) findViewById(R.id.anim_bg);
            AnimationDrawable fromAnimation = (AnimationDrawable) img.getBackground();
            fromAnimation.start();
        }
    }

    class SlideEnd extends TimerTask {

        @Override
        public void run() {
            ImageView img = (ImageView) findViewById(R.id.anim_bg);
            AnimationDrawable fromAnimation = (AnimationDrawable) img.getBackground();
            fromAnimation.stop();
        }
    }
}
