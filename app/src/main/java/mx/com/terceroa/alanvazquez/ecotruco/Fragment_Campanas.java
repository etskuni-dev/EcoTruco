package mx.com.terceroa.alanvazquez.ecotruco;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by AlanVazquez on 15/03/17.
 */
public class Fragment_Campanas extends Fragment {

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState ){
        super.onViewCreated(view , savedInstanceState);

        getActivity().setTitle("Campañas");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_campanas, container, false);
    }
}
