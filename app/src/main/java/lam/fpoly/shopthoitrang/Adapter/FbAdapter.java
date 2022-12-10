package lam.fpoly.shopthoitrang.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lam.fpoly.shopthoitrang.Dao.TbHoaDonChiTietDao;
import lam.fpoly.shopthoitrang.Dao.TbKhachHangDao;
import lam.fpoly.shopthoitrang.Model.TbDonHang;
import lam.fpoly.shopthoitrang.Model.TbFeedBack;
import lam.fpoly.shopthoitrang.R;


public class FbAdapter extends RecyclerView.Adapter<FbAdapter.GioHangViewHolder>{
    private List<TbFeedBack> list;

    public void setData(List<TbFeedBack> mlist){
        this.list = mlist;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public GioHangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feedback,parent,false);
        return new GioHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangViewHolder viewHolder, int position) {
        int i = position;
        TbFeedBack obj = list.get(position);
        if (obj == null){
            return;
        }

        TbKhachHangDao tbKhachHangDao = new TbKhachHangDao();
        Picasso.get().load(tbKhachHangDao.getUser(obj.getId_khachhang()).getAvatar()).fit().into(viewHolder.fb_avatar);
        viewHolder.fb_name.setText(tbKhachHangDao.getUser(obj.getId_khachhang()).getTen_khachHang());
        viewHolder.fb_star.setText("Đánh giá: "+obj.getSoStar()+" sao");
        viewHolder.fb_mess.setText(obj.getMess());
        Picasso.get().load(obj.getAnh()).fit().into(viewHolder.fb_img);

    }

    @Override
    public int getItemCount() {
        if (list.size() != 0){
            return list.size();
        }
        return 0;
    }

    public class GioHangViewHolder extends RecyclerView.ViewHolder{
        private TextView fb_name,fb_star,fb_mess;
        private ImageView fb_avatar,fb_img;
        public GioHangViewHolder(@NonNull View itemView) {
            super(itemView);
            fb_name = itemView.findViewById(R.id.fb_name);
            fb_star = itemView.findViewById(R.id.fb_star);
            fb_mess = itemView.findViewById(R.id.fb_mess);
            fb_avatar = itemView.findViewById(R.id.fb_avatar);
            fb_img = itemView.findViewById(R.id.fb_img);
        }
    }
}
