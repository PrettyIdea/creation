package surpport;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * 分页bean
 * @author linlinsong
 *
 * @param <T>
 */
public class PageBean<T>{
    private Collection<T> list;
    private int pageNum = 1;
    private int numPerPage = 20;
    private int totalCount = 0;
    private Map<String, String[]> queryParam = Collections.emptyMap();
    
    public PageBean() {
    }
    public PageBean(Map<String, String[]> queryParam) {
        this.setQueryParam(queryParam);
    }
    /**
     * @return the list
     */
    public Collection<T> getList() {
        return list;
    }
    /**
     * @param list the list to set
     */
    public void setList(Collection<T> list) {
        this.list = list;
    }
    /**
     * @return the pageNum
     */
    public int getPageNum() {
        return pageNum;
    }
    /**
     * @param pageNum the pageNum to set
     */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    /**
     * @return the numPerPage
     */
    public int getNumPerPage() {
        return numPerPage;
    }
    /**
     * @param numPerPage the numPerPage to set
     */
    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }
    /**
     * @return the totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }
    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    /**
     * @return the queryParam
     */
    public Map<String, String[]> getQueryParam() {
        return queryParam;
    }
    /**
     * 前台传递的检索参数初始化分页的属性
     * @param queryParam
     */
    public void setQueryParam(Map<String, String[]> queryParam) {
        String[] pageNumStr = queryParam.get("pageNum");
        if(pageNumStr != null && pageNumStr.length != 0) {
            this.pageNum = Integer.parseInt(pageNumStr[0]);
        }
        String[] numPerPageStr = queryParam.get("numPerPage");
        if(numPerPageStr != null && numPerPageStr.length != 0) {
            this.numPerPage = Integer.parseInt(numPerPageStr[0]);
        }
        this.queryParam = queryParam;
    }
    public int getOffset() {
        return this.numPerPage * (this.pageNum - 1);
    }
    /**
     * @return 总共有多少页
     */
    public int getPageCount(){
        return (this.totalCount + this.numPerPage) / this.numPerPage;
    }
}
