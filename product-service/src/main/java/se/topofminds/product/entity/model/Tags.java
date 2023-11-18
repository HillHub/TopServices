package se.topofminds.product.entity.model;

import java.util.List;

public class Tags {

	List<String> city;
	List<String> roomSelections;

	public List<String> getCity() {
		return city;
	}

	public void setCity(List<String> city) {
		this.city = city;
	}

	public List<String> getRoomSelections() {
		return roomSelections;
	}

	public void setRoomSelections(List<String> roomSelections) {
		this.roomSelections = roomSelections;
	}

	public String toString() {

		StringBuffer buffer = new StringBuffer();

		if (city != null) {
			for (String out : city) {
				buffer.append("]  [" + out);
			}
		}

		if (roomSelections != null) {
			for (String out : roomSelections) {
				buffer.append("]  [" + out);
			}
		}

		return buffer.toString();
	}

}
