package bwie.com.textframe;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwie.com.textframe.fragment.CarFragment;
import bwie.com.textframe.fragment.ClassifyFragment;
import bwie.com.textframe.fragment.HomeFragment;
import bwie.com.textframe.fragment.MyFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    @BindView(R.id.rd_home)
    RadioButton mRdHome;
    @BindView(R.id.rd_classify)
    RadioButton mRdClassify;
    @BindView(R.id.rd_car)
    RadioButton mRdCar;
    @BindView(R.id.rd_my)
    RadioButton mRdMy;
    private FragmentTransaction mFragmentTransaction;
    private HomeFragment mHomeFragment;
    private ClassifyFragment mClassifyFragment;
    private CarFragment mCarFragment;
    private MyFragment mMyFragment;
    private FragmentManager mSupportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mHomeFragment = new HomeFragment();
        mClassifyFragment = new ClassifyFragment();
        mCarFragment = new CarFragment();
        mMyFragment = new MyFragment();

        mSupportFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mSupportFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.fragment_container, mHomeFragment);
        mFragmentTransaction.commit();
    }

    @OnClick({R.id.rd_home, R.id.rd_classify, R.id.rd_car, R.id.rd_my})
    public void onViewClicked(View view) {
        mFragmentTransaction = mSupportFragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.rd_home:
                if (!mHomeFragment.isAdded()) {
                    mFragmentTransaction.add(R.id.fragment_container, mHomeFragment);
                }
                mFragmentTransaction.show(mHomeFragment)
                        .hide(mClassifyFragment)
                        .hide(mCarFragment)
                        .hide(mMyFragment)
                        .commit();
                break;
            case R.id.rd_classify:
                if (!mClassifyFragment.isAdded()) {
                    mFragmentTransaction.add(R.id.fragment_container, mClassifyFragment);
                }
                mFragmentTransaction.show(mClassifyFragment)
                        .hide(mHomeFragment)
                        .hide(mCarFragment)
                        .hide(mMyFragment)
                        .commit();
                break;
            case R.id.rd_car:
                if (!mCarFragment.isAdded()) {
                    mFragmentTransaction.add(R.id.fragment_container, mCarFragment);
                }
                mFragmentTransaction.show(mCarFragment)
                        .hide(mClassifyFragment)
                        .hide(mHomeFragment)
                        .hide(mMyFragment)
                        .commit();
                break;
            case R.id.rd_my:
                if (!mMyFragment.isAdded()) {
                    mFragmentTransaction.add(R.id.fragment_container, mMyFragment);
                }
                mFragmentTransaction.show(mMyFragment)
                        .hide(mHomeFragment)
                        .hide(mCarFragment)
                        .hide(mClassifyFragment)
                        .commit();
                break;
        }
    }
}
