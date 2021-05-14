public class MSG {
    private String body; //MSG Body

	private int destID; //ID of destination Entity!

    public MSG(String body,int destID) {
        this.body = body;
        this.destID = destID;
    }

    public String getBody() {
        return body;
    }

    public int getDestID() {
        return destID;
    }

    public void setDestID(int destID) {
        this.destID = destID;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
