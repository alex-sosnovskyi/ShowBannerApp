package ua.i.pl.sosnovskyi.aleksandr.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import ua.i.pl.sosnovskyi.aleksandr.myapplication.utils.Callback;
import ua.i.pl.sosnovskyi.aleksandr.myapplication.utils.GenericActivity;

public final class MainActivity extends GenericActivity implements Callback{
private  ProgressBar progressBar;
private  int progress;
private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(ProgressBar.VISIBLE);
        getLauncher().launchBannerFragment();
        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (progressBar.getProgress() < progressBar.getMax()) {
                    progressBar.incrementProgressBy(1);
                    handler.sendEmptyMessageDelayed(0, 100);
                } else {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    getLauncher().launchMenuFragment();
                }
            }
        };
        handler.sendEmptyMessageDelayed(0, 2000);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getLauncher().launchBannerFragment();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                getLauncher().launchMenuFragment();
            }
        }, 2000);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void openNews(final int id) {
        getLauncher().launchBannerFragment();
       Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                getLauncher().launchNewsFragment(id);
            }
        }, 2000);

    }
}
