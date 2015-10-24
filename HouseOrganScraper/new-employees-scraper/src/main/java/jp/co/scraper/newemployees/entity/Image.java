package jp.co.scraper.newemployees.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 画像テーブル モデルクラス.
 *
 * @author user, generated by ERMaster
 */
public class Image implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** ファイルパス */
    private String filePath;

    /** 登録日 */
    private Date created;

    /** 更新日 */
    private Date modified;

    /** 社員紹介テーブル 一覧 */
    private List<Profile> profiles;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return the modified
     */
    public Date getModified() {
        return modified;
    }

    /**
     * @param modified the modified to set
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * @return the profiles
     */
    public List<Profile> getProfiles() {
        return profiles;
    }

    /**
     * @param profiles the profiles to set
     */
    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Image ["
                + "id=" + id
                + ", filePath=" + filePath
                + ", created=" + created
                + ", modified=" + modified
                + ", profiles=" + profiles
                + "]";
    }
}