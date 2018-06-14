package ua.i.pl.sosnovskyi.aleksandr.myapplication.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ua.i.pl.sosnovskyi.aleksandr.myapplication.R;

/**
 * Created by Aleksandr on 13.06.2018.
 */

public class BannerFragment extends Fragment {
    private  ImageView image;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.banner_fragment, null) ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        image = view.findViewById(R.id.banner);
    }

    @Override
    public void onResume() {
        super.onResume();
        int icon = getResources().getIdentifier("banner1","drawable",  getContext().getPackageName());
        Picasso.with(getContext()).load(icon).into(image);
    }
}
