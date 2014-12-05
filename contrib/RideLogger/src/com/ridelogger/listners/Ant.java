package com.ridelogger.listners;

import com.dsi.ant.plugins.antplus.pcc.defines.DeviceState;
import com.dsi.ant.plugins.antplus.pccbase.PccReleaseHandle;
import com.dsi.ant.plugins.antplus.pccbase.AntPluginPcc.IDeviceStateChangeReceiver;
import com.dsi.ant.plugins.antplus.pccbase.AntPluginPcc.IPluginAccessResultReceiver;
import com.dsi.ant.plugins.antplus.pccbase.MultiDeviceSearch.MultiDeviceSearchResult;

import com.ridelogger.RideService;


/**
 * Ant
 * @author Chet Henry
 * Listen to and log Ant+ events base class
 */
public class Ant extends Base<Object>
{
    public PccReleaseHandle<?>            releaseHandle;    //Handle class
    public IPluginAccessResultReceiver<?> mResultReceiver;  //Receiver class
    
    //setup listeners and logging 
    public Ant(MultiDeviceSearchResult result, RideService mContext)
    {
        super(mContext);
    }
    
    
    IDeviceStateChangeReceiver mDeviceStateChangeReceiver = new IDeviceStateChangeReceiver()
    {
        @Override
        public void onDeviceStateChange(final DeviceState newDeviceState){
            //if we lose a device zero out its values
            if(newDeviceState.equals(DeviceState.DEAD)) {
                zeroReadings();
            }
        }
    };

    @Override
    public void onDestroy()
    {
        if(releaseHandle != null) {
            releaseHandle.close();
        }
    }
    
    @Override
    public void writeData(int key, float value)
    {
        super.writeData(key, value);
    }
    
    
    @Override
    public void writeData(int[] keys, float[] values)
    {
        super.writeData(keys, values);
    }


    @Override
    public void alterCurrentData(int key, float value)
    {
        super.alterCurrentData(key, value);
    }
    
    @Override
    public void alterCurrentData(int[] keys, float[] values)
    {
        super.alterCurrentData(keys, values);
    }
    
    
    public void zeroReadings() {}
}


