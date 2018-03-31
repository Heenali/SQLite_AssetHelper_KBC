package com.sqliteassethelper.demo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewPagerAdapter extends PagerAdapter {
	// Declare Variables
	Context context;
	String[] text1;
	String[] text2;
	String[] text3;
	String[] text4;
	String[] text5;
	LayoutInflater inflater;

	public ViewPagerAdapter(Context context, String[] rank, String[] country,
                            String[] population, String[] population2,String[] population3) {
		this.context = context;
		this.text1 = rank;
		this.text2 = country;
		this.text3 = population;
		this.text4 = population2;
		this.text5 = population3;
	}


	@Override
	public int getCount() {
		return text1.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((RelativeLayout) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, final int position) {

		// Declare Variables
		TextView txtrank;
		TextView txtcountry;
		TextView txtpopulation;
		ImageView imgflag;
		RadioButton r1,r2,r3,r4;

		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.viewpager_item, container,
				false);

		// Locate the TextViews in viewpager_item.xml
		txtrank = (TextView) itemView.findViewById(R.id.rank);
		txtcountry = (TextView) itemView.findViewById(R.id.country);
		txtpopulation = (TextView) itemView.findViewById(R.id.population);
		r1=(RadioButton)itemView.findViewById(R.id.ans1);
		r2=(RadioButton)itemView.findViewById(R.id.ans2);
		r3=(RadioButton)itemView.findViewById(R.id.ans3);
		r4=(RadioButton)itemView.findViewById(R.id.ans4);

		// Capture position and set to the TextViews
		txtrank.setText(text1[position]);
		txtcountry.setText(text1[position]);
		txtpopulation.setText(text3[position]);
		r1.setText(text2[position]);
		r2.setText(text3[position]);
		r3.setText(text4[position]);
		r4.setText(text5[position]);


		// Locate the ImageView in viewpager_item.xml
		/*imgflag = (ImageView) itemView.findViewById(R.id.flag);
		// Capture position and set to the ImageView
		imgflag.setImageResource(flag[position]);
		imgflag.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Toast.makeText(context,rank[position]+"", Toast.LENGTH_SHORT).show();
			}
		});*/
		// Add viewpager_item.xml to ViewPager
		((ViewPager) container).addView(itemView);

		return itemView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// Remove viewpager_item.xml from ViewPager
		((ViewPager) container).removeView((RelativeLayout) object);

	}
}
