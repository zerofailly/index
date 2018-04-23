package cn.ucwork.bean;

public class Code {
	private String code_id = null;
	private String fileName;
	private String path;
	private String content = null;
	private String compileType = null;
	private String is_public;
	private String is_copy;
	private String description;
	private String user_id = null;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCode_id() {
		return code_id;
	}
	public void setCode_id(String code_id) {
		this.code_id = code_id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCompileType() {
		return compileType;
	}
	public void setCompileType(String compileType) {
		this.compileType = compileType;
	}
	public String getIs_public() {
		return is_public;
	}
	public void setIs_public(String is_public) {
		this.is_public = is_public;
	}
	public String getIs_copy() {
		return is_copy;
	}
	public void setIs_copy(String is_copy) {
		this.is_copy = is_copy;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
