/**
 * Osmdroid Sample
 * 2019-02-01 K.OHWADA 
 */

package jp.ohwada.android.osmdroid1;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;

 import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapController;
import  org.osmdroid.util.GeoPoint;
import org.osmdroid.api.IGeoPoint;
import  org.osmdroid.api.IMapController;


/**
 *  class MainActivity
 */
public class MainActivity extends Activity {

    // yokohama
    private static final double MAP_LAT = 35.4472391;
    private static final double MAP_LON = 139.6414945;

    private static final double MAP_ZOOM = 6.0;

    private MapView mMapView = null;


/**
 *  onCreate
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         setContentView(R.layout.activity_main);

       Configuration.getInstance().load(getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));

    mMapView = (MapView) findViewById(R.id.mapView);

     mMapView.setBuiltInZoomControls(true);
     mMapView.setMultiTouchControls(true);

       IMapController mapController =  mMapView.getController();
         mapController.setZoom(MAP_ZOOM);
          GeoPoint centerPoint = new GeoPoint(MAP_LAT,MAP_LON);
          mapController.setCenter(centerPoint);

    } //  onCreate


/**
 *  onResume
 */
    @Override
    public void onResume(){
        super.onResume();
        if (mMapView!=null) {
            mMapView.onResume();
        }
    } // onResume


/**
 *  onPause
 */
    @Override
    public void onPause(){
        super.onPause();
        if (mMapView!=null) {
            mMapView.onPause();
        }
    } // onPause

} // class MainActivity