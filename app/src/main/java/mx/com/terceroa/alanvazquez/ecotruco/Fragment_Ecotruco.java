package mx.com.terceroa.alanvazquez.ecotruco;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlanVazquez on 15/03/17.
 */
public class Fragment_Ecotruco extends Fragment  {

    RecyclerView rv;
    List<Truco> trucos;
    Adapter adapter;

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState ){
        super.onViewCreated(view , savedInstanceState);


        rv = (RecyclerView) view.findViewById(R.id.recycler);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        trucos = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        adapter = new Adapter(getContext(), trucos);
        rv.setAdapter(adapter);

        //Se puede usar metodo getRoot() para obtener datos desde la raiz
        database.getReference("Trucos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                trucos.removeAll(trucos);
                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {
                    Truco truco = snapshot.getValue(Truco.class);
                    trucos.add(truco);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        getActivity().setTitle("Trucos");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){

        return inflater.inflate(R.layout.fragment_ecotruco, container, false);
    }
}
