package com.github.joaogouveia.propertyanimationexample.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.joaogouveia.propertyanimationexample.R;
import com.github.joaogouveia.propertyanimationexample.util.SimpleAnimatorListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RotationFragment extends Fragment {

    @Bind(R.id.view)
    View view;

    public static RotationFragment newInstance() {
        RotationFragment fragment = new RotationFragment();
        return fragment;
    }

    public RotationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button)
    void run() {

//        AnimatorSet animatorSet = new AnimatorSet();
//        ObjectAnimator animRotationIn = ObjectAnimator.ofFloat(view, "rotation", 0f, 180f);
//        ObjectAnimator animRotationOut = ObjectAnimator.ofFloat(view, "rotation", 180f, 0f);
//        animatorSet.playSequentially(animRotationIn, animRotationOut);
//        animatorSet.setDuration(1000);
//        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
//        animatorSet.start();

        //.withEndAction e .withStartAction podem ser usados em caso de API 16+
        view.animate()
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(1000)
                .rotation(180f)
                .setListener(new SimpleAnimatorListener() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        view.animate()
                                .setInterpolator(new FastOutSlowInInterpolator())
                                .setDuration(1000)
                                .rotation(0f);
                    }
                });
    }


}
