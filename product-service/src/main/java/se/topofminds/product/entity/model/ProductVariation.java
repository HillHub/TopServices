package se.topofminds.product.entity.model;

import java.util.Map;

public class ProductVariation {

	private String taxGroupId;
	private String imageUrl;
	private String name;
	private Map<String, String> displayNames;
	private String description;
	private Integer weight;
	private Map<String, String> displayDescriptions;
	private Boolean isActive;
	private String productParentId;
	private Map<String, String> customAttributes;
	private Tags tags;
	private Dimensions dimensions;

	
	
	public String getTaxGroupId() {
		return taxGroupId;
	}



	public void setTaxGroupId(String taxGroupId) {
		this.taxGroupId = taxGroupId;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Map<String, String> getDisplayNames() {
		return displayNames;
	}



	public void setDisplayNames(Map<String, String> displayNames) {
		this.displayNames = displayNames;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Integer getWeight() {
		return weight;
	}



	public void setWeight(Integer weight) {
		this.weight = weight;
	}



	public Map<String, String> getDisplayDescriptions() {
		return displayDescriptions;
	}



	public void setDisplayDescriptions(Map<String, String> displayDescriptions) {
		this.displayDescriptions = displayDescriptions;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}



	public String getProductParentId() {
		return productParentId;
	}



	public void setProductParentId(String productParentId) {
		this.productParentId = productParentId;
	}



	public Map<String, String> getCustomAttributes() {
		return customAttributes;
	}



	public void setCustomAttributes(Map<String, String> customAttributes) {
		this.customAttributes = customAttributes;
	}



	public Tags getTags() {
		return tags;
	}



	public void setTags(Tags tags) {
		this.tags = tags;
	}



	public Dimensions getDimensions() {
		return dimensions;
	}



	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}



	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Map.Entry<String, String> entry : displayNames.entrySet()) {
			buffer.append("] [" + entry.getKey());
			buffer.append("] [" + entry.getValue());
		}

		for (Map.Entry<String, String> entry : displayDescriptions.entrySet()) {
			buffer.append("] [" + entry.getKey());
			buffer.append("] [" + entry.getValue());
		}

		for (Map.Entry<String, String> entry : customAttributes.entrySet()) {
			buffer.append("] [" + entry.getKey());
			buffer.append("] [" + entry.getValue());
		}
		
		
		

		return "[" + taxGroupId + "]  "
				+ "[" + imageUrl + 
				"]  [" + name + 
				"]  [" + description + 
				"]  [" + weight + 
				"]  [" + productParentId + 
				"]  [" + isActive + 
				"]  [" + dimensions.toString() + 

				"]  [" + buffer.toString() + 
				tags.toString();
	}

}
