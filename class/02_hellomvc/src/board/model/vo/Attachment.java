package board.model.vo;

public class Attachment {
	
	private int no; //attachment no
	private int boardNo;
	private String orginalFileName;
	private String renamedFileName;
	private boolean status; // staus Y | N 처리되므로, JDBC에서 형변환 필요.
	
	public Attachment() {
		super();
	}
	public Attachment(int no, int boardNo, String orginalFileName, String renamedFileName, boolean status) {
		super();
		this.no = no;
		this.boardNo = boardNo;
		this.orginalFileName = orginalFileName;
		this.renamedFileName = renamedFileName;
		this.status = status;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getOrginalFileName() {
		return orginalFileName;
	}
	public void setOrginalFileName(String orginalFileName) {
		this.orginalFileName = orginalFileName;
	}
	public String getRenamedFileName() {
		return renamedFileName;
	}
	public void setRenamedFileName(String renamedFileName) {
		this.renamedFileName = renamedFileName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Attachment [no=" + no + ", boardNo=" + boardNo + ", orginalFileName=" + orginalFileName
				+ ", renamedFileName=" + renamedFileName + ", status=" + status + "]";
	}

}
