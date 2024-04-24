package edu.kh.music.board.model.dto;


public class Pagination {
	
	private int currentPage;
	private int listCount;
	
	private int limit = 15;
	private int pageSize = 10;
	
	private int maxPage;
	private int startPage;
	private int endPage;
	
	private int prevPage;
	private int nextPage;
	
	public Pagination(int currentPage, int listCount) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		
		calculate();
	}
	
	public Pagination(int currentPage, int listCount, int limit, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.listCount = listCount;
		this.limit = limit;
		this.pageSize = pageSize;
		
		calculate();
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}

	public int getListCount() {
		return listCount;
	}

	public int getLimit() {
		return limit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}
	

	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		
		calculate();
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
		calculate();
	}

	public void setLimit(int limit) {
		this.limit = limit;
		calculate();
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		calculate();
	}


	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", listCount=" + listCount + ", limit=" + limit
				+ ", pageSize=" + pageSize + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", prevPage=" + prevPage + ", nextPage=" + nextPage + "]";
	}


	private void calculate() {
		maxPage = (int)Math.ceil((double)listCount / limit);
		
		startPage = (currentPage -1) / pageSize * pageSize + 1;
		
		endPage = pageSize - 1 + startPage;
		
		if(endPage>maxPage) endPage = maxPage;
		
		if(currentPage < pageSize) prevPage = 1;
		else prevPage = startPage - 1;
		
		if(endPage == maxPage) nextPage = maxPage;
		else nextPage = endPage + 1;
	}

	

}
