package lam.fpoly.shopthoitrang.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

import lam.fpoly.shopthoitrang.AccFragment.DangNhapActivity;
import lam.fpoly.shopthoitrang.Adapter.ViewPagerAdapter;
import lam.fpoly.shopthoitrang.Adapter.ViewPagerAdapterHome;
import lam.fpoly.shopthoitrang.Dao.TbKhachHangDao;
import lam.fpoly.shopthoitrang.MainActivity;
import lam.fpoly.shopthoitrang.Model.TbKhachHang;
import lam.fpoly.shopthoitrang.MyDataBase.MyDataBase_Temporary;
import lam.fpoly.shopthoitrang.Object.DonHang_Temorary;
import lam.fpoly.shopthoitrang.R;


public class Home_Fragment extends Fragment {
    TabLayout idTabHome;
    ViewPager2 idViewHome;
    CardView avt_User;
    TextView tvUserAddress,tvUserName;

    String [] title = {"Tất cả","Sản phẩm mới","Gần đây","Khuyến mại"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        avt_User = view.findViewById(R.id.avt_User);
        tvUserName = view.findViewById(R.id.tvUserName);
        tvUserAddress = view.findViewById(R.id.tvUserAddress);

        TbKhachHangDao tbKhachHangDao = new TbKhachHangDao();
        System.out.println(DangNhapActivity.ID);
//        tvUserName.setText(tbKhachHangDao.getUser(DangNhapActivity.ID).getTen_khachHang());
//        tvUserAddress.setText(tbKhachHangDao.getUser(DangNhapActivity.ID).getDiaChi());

        avt_User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("Home",4);
                startActivity(intent);
            }
        });

        ScrollTab(view);
    }

    public void ScrollTab(View view){

        idTabHome = view.findViewById(R.id.idTabHome);
        idViewHome = view.findViewById(R.id.idViewHome);
        ViewPagerAdapterHome adapter = new ViewPagerAdapterHome(getActivity());
        idViewHome.setAdapter(adapter);
        new TabLayoutMediator(idTabHome, idViewHome,((tab, position) ->
                tab.setText(title[position]))).attach();
        idTabHome.setTabGravity(TabLayout.GRAVITY_CENTER);
        idTabHome.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}