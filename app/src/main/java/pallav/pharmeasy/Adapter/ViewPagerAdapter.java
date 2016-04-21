package pallav.pharmeasy.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import pallav.pharmeasy.R;
import pallav.pharmeasy.model.Medicine;


public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    LayoutInflater inflater;
    List<Medicine> markerObjects;

    public ViewPagerAdapter(Context context, List<Medicine> marker) {
        this.context = context;
        this.markerObjects = marker;

    }

    @Override
    public int getCount() {
        return markerObjects.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        TextView txtrank;
        ImageView imgflag;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.view_pager, container,
                false);
        // Locate the TextViews in viewpager_item.xml
        txtrank = (TextView) itemView.findViewById(R.id.rank);

        // Capture position and set to the TextViews
        txtrank.setText(markerObjects.get(position).getName());

        // Locate the ImageView in viewpager_item.xml
        imgflag = (ImageView) itemView.findViewById(R.id.flag);
        imgflag.setImageResource(R.drawable.pills);
        // Capture position and set to the ImageView


        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}