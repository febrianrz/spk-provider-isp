package alterindonesia.project.com.spkproviderisp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaketResponse {
    @SerializedName("paket")
    @Expose
    private String paket;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("price")
    @Expose
    private String price;

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
