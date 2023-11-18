package se.topofminds.product.entity.model;

public class Dimensions {

	private Integer width;
	private Integer length;
	private Integer height;

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String toString() {
		return "] [" + width + "]  [" + length + "]  [" + height;
	}
}
