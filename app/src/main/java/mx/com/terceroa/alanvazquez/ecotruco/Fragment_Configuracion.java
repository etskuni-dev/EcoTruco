package mx.com.terceroa.alanvazquez.ecotruco;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by AlanVazquez on 11/04/17.
 */

public class Fragment_Configuracion extends Fragment implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private Button Cerrar;
    private TextView Usr;

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState ){
        super.onViewCreated(view , savedInstanceState);

        Cerrar = (Button) view.findViewById(R.id.buttonCerrar);
        Usr = (TextView) view.findViewById(R.id.textView);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            getActivity().finish();
            startActivity(new Intent(getContext(), Ingreso.class));
        }

        FirebaseUser User = firebaseAuth.getCurrentUser();

        Usr.setText("Bienvenido: " + User.getEmail());
        Cerrar.setOnClickListener(this);

        getActivity().setTitle("Configuración");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_configuracion, container, false);
    }

    @Override
    public void onClick(View v) {
        if (v == Cerrar){
            firebaseAuth.signOut();
            getActivity().finish();
            startActivity(new Intent(getContext(), Ingreso.class));
        }
    }
}
