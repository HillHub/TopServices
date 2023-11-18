package se.topofminds.product.entity.model;

import java.util.Map;

public class ProductMaster {
	
	private String name;
		
	private Map<String,String> displayNames;
	private Map<String,String> displayDescriptions;
	
	private String description;
	
	private String imageUrl;
	private Boolean isActive;
	private Map<String,String> customAttributes;
	private Tags tags;

	
	
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



	public Map<String, String> getDisplayDescriptions() {
		return displayDescriptions;
	}



	public void setDisplayDescriptions(Map<String, String> displayDescriptions) {
		this.displayDescriptions = displayDescriptions;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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



	public String toString() {
		StringBuffer buffer = new StringBuffer();	
		for (Map.Entry<String, String> entry : displayNames.entrySet()) {
			buffer.append("] ["+entry.getKey());
			buffer.append("] ["+entry.getValue());			
		}
		
		for (Map.Entry<String, String> entry : displayDescriptions.entrySet()) {
			buffer.append("] ["+entry.getKey());
			buffer.append("] ["+entry.getValue());			
		}
		
		for (Map.Entry<String, String> entry : customAttributes.entrySet()) {
			buffer.append("] ["+entry.getKey());
			buffer.append("] ["+entry.getValue());			
		}
		
		return "["+ name+
		"]  ["+ imageUrl+
		"]  ["+ isActive+
		"]  ["+ buffer.toString()+		
		tags.toString();
	}

}
