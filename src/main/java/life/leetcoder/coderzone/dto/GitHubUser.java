package life.leetcoder.coderzone.dto;

/**
 * @author laynewei
 * @time 9/19/20 1:45 AM
 * @e-mail lengning_wei@berkeley.edu
 */
public class GitHubUser {
    private long id;
    private String name;
    private String bio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
