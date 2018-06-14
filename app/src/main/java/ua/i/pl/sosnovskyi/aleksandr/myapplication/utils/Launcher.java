package ua.i.pl.sosnovskyi.aleksandr.myapplication.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import ua.i.pl.sosnovskyi.aleksandr.myapplication.ui.BannerFragment;
import ua.i.pl.sosnovskyi.aleksandr.myapplication.ui.MenuFragment;
import ua.i.pl.sosnovskyi.aleksandr.myapplication.R;
import ua.i.pl.sosnovskyi.aleksandr.myapplication.ui.NewsFragment;

/**
 * Created by Aleksandr on 13.06.2018.
 */

public class Launcher {
    private final FragmentManager fragmentManager;
    private final int fragmentContainer;

    public Launcher(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        this.fragmentContainer = R.id.fragment_container;
    }

    private void launch(Fragment fragment) {
        launch(fragment, fragmentManager);
    }

    private void launch(Fragment fragment, FragmentManager fragmentManager) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainer, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void launchBannerFragment() {
        launch(new BannerFragment());
    }

    public void launchMenuFragment() {
        launch(new MenuFragment());
    }

    public void launchNewsFragment(int id) {
        launchAndAddToBackStack(NewsFragment.makeInstance(id));
    }

    private void launchAndAddToBackStack(Fragment fragment) {
        launchWhithBackStack(fragment, fragmentManager);
    }

    private void launchWhithBackStack(Fragment fragment, FragmentManager fragmentManager) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
