package com.acacias.altfc;

import java.util.ArrayList;
import java.util.Random;

public class Images {

	private Random randNo;
	private ArrayList<Integer> imageId;

	public Images() {
		imageId = new ArrayList<Integer>();
		imageId.add(R.drawable.mateo_robbie_alex);
		imageId.add(R.drawable.courtney_halpin);
		imageId.add(R.drawable.sammy_scarlato);
		imageId.add(R.drawable.stephanie_fyfe);
		imageId.add(R.drawable.carla_cannini);
	}

	public int getImageId() {
		randNo = new Random();
		return imageId.get(randNo.nextInt(imageId.size()));
	}

	public ArrayList<Integer> getImageItem() {
		return imageId;
	}
}
