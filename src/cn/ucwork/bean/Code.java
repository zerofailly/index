package cn.ucwork.bean;

public class Code {
	private String fileName;
	private String path;
	private String content = null;
	private String compileType = null;
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
	
}
