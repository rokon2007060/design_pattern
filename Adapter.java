/*Name:Al Shahriar Rokon
 * Roll: 2007060
 * Using:Adapter and bridge
 * 
 */


interface TV{
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int volume);
    int getChannel();
    void setChannel(int channel);
}

class SmartTV implements TV{
    boolean powerOn;
    int volume,channel;
    public boolean isEnabled(){return this.powerOn;}
    public void enable(){this.powerOn=true;System.out.println("smartTV powered on");}
    public void disable(){this.powerOn=false;System.out.println("smartTV powered off");}
    public int getVolume(){return this.volume;}
    public void setVolume(int volume){this.volume=volume;System.out.println("volume set complete for smart TV");}
    public int getChannel(){return this.channel;}
    public void setChannel(int channel){this.channel=channel;System.out.println("channel set successfully for smart tv");}
    public void youtube(){System.out.println("Youtube is running");};
}

class GeneralTV implements TV{
    boolean powerOn;
    int volume,channel;
    public boolean isEnabled(){ return this.powerOn;}
    public void enable(){this.powerOn=true;System.out.println("GeneralTV powered on");}
    public void disable(){this.powerOn=false;System.out.println("GeneralTV powered off");}
    public int getVolume(){return this.volume;}
    public void setVolume(int volume){this.volume=volume;System.out.println("volume set complete for general TV");}
    public int getChannel(){return this.channel;}
    public void setChannel(int channel){this.channel=channel;System.out.println("channel set successfully for general TV");}
}


// SmartTVAdapter class that implements TV and has a SmartTV field
class SmartTVAdapter implements TV {
    private SmartTV smartTV;
    public SmartTVAdapter(SmartTV smartTV) {
      this.smartTV = smartTV;
    }

    public boolean isEnabled() {
      return smartTV.isEnabled();
    }

    public void enable() {
      smartTV.enable();
    }

    public void disable() {
      smartTV.disable();
    }
  
    public int getVolume() {
      return smartTV.getVolume();
    }
  
    public void setVolume(int volume) {
      smartTV.setVolume(volume);
    }
  
    public int getChannel() {
      return smartTV.getChannel();
    }
  
    public void setChannel(int channel) {
      smartTV.setChannel(channel);
    }

    public void youtube() {
      smartTV.youtube();
    }
  }
  

class Remote{
    protected TV tv;
    public Remote(){}

    public Remote(SmartTV tv)
    {
      this.tv = tv;
    }

    public Remote(GeneralTV generalTV)
    {
      this.tv=generalTV;
    }

    public void togglePower()
    {
        tv.enable();
    }

    public void volumeUp()
    {
      tv.setVolume(tv.getVolume()+1);
    }

    public void volumeDown()
    {
      tv.setVolume(tv.getVolume()-1);
    }

    public void channelUp()
    {
      tv.setChannel(tv.getChannel()+1);
    }

    public void channelDown()
    {
      tv.setChannel(tv.getChannel()-1);
    }
}


class SmartRemote extends Remote{
  public SmartRemote(SmartTV smartTV) {
    this.tv = new SmartTVAdapter(smartTV);
  }

  public SmartRemote(GeneralTV tv) {
    this.tv = tv;
  }
  
  public void showYoutube() {
    if(tv instanceof SmartTVAdapter)
    {
      SmartTVAdapter adapter = (SmartTVAdapter) tv;
      adapter.youtube();
    }
    else{
      System.out.println("This is a feature of smartTV . press any key to go back");
    }
    
  }
  public void togglePower()
    {
        tv.enable();
    }

    public void volumeUp()
    {
      tv.setVolume(tv.getVolume()+1);
    }

    public void volumeDown()
    {
      tv.setVolume(tv.getVolume()-1);
    }

    public void channelUp()
    {
      tv.setChannel(tv.getChannel()+1);
    }

    public void channelDown()
    {
      tv.setChannel(tv.getChannel()-1);
    }
}


public class Adapter {
    public static void main(String[] args) {
        SmartTV smartTV = new SmartTV();
        GeneralTV generalTV = new GeneralTV();
        SmartRemote smartRemote = new SmartRemote(smartTV);
        SmartRemote smartRemote1 = new SmartRemote(generalTV);
        Remote remote = new Remote(generalTV);
        Remote remote1 = new Remote(smartTV);

        //using smart remote for smartTV
        System.out.println("using smart remote for smartTV");
        System.out.println("\n");
        smartRemote.togglePower();
        smartRemote.channelUp();
        smartRemote.channelDown();
        smartRemote.volumeUp();
        smartRemote.volumeDown();
        smartRemote.showYoutube();

        //using general remote for generalTV
        System.out.println("\n\n");
        System.out.println("using general remote for generalTV");
        System.out.println("\n");
        remote.togglePower();
        remote.channelUp();
        remote.channelDown();
        remote.volumeUp();
        remote.volumeDown();
      
        //using general remote for smart tv
        System.out.println("\n\n");
        System.out.println("using general remote for smart tv");
        System.out.println("\n");
        remote1.togglePower();
        remote1.channelUp();
        remote1.channelDown();
        remote1.volumeUp();
        remote1.volumeDown();

        //using smart remote for general tv
        
        System.out.println("\n\n");
        System.out.println("using smart remote for general tv");
        System.out.println("\n");
        smartRemote1.togglePower();
        smartRemote1.channelUp();
        smartRemote1.channelDown();
        smartRemote1.volumeUp();
        smartRemote1.volumeDown();
        smartRemote1.showYoutube();//this is not a smartTv show one message will be shown to the user
    }
    
}