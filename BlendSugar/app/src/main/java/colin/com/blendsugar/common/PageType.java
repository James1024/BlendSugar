package colin.com.blendsugar.common;

/**
 * @author yiche
 * @date 2018/7/10
 */
public enum PageType {
    CUSTOM_VIEW(0,""),

    ANIMATION(1,""),

    UTIL(2,"");

    private int mType;
    private String mContent;

    PageType(int type,String content) {
        this.mType=type;
        this.mContent=content;
    }

    public String getContent(){
        return mContent;
    }

    public int getType(){
        return mType;
    }

    public static PageType findTypeById(int type){
        switch (type){
            case 0:
                return CUSTOM_VIEW;
            case 1:
                return ANIMATION;
                default:
                    return CUSTOM_VIEW;
        }
    }

}
