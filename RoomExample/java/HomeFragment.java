package com.example.roomexample;


import android.os.Bundle;
import android.provider.BlockedNumberContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private Button BnAddUser, BnReadUser, BnDelete, BnUpdate;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        BnAddUser = view.findViewById(R.id.bn_add_user);
        BnAddUser.setOnClickListener(this);

        BnReadUser = view.findViewById(R.id.bn_view_users);
        BnReadUser.setOnClickListener(this);

        BnDelete = view.findViewById(R.id.bn_delete_user);
        BnDelete.setOnClickListener(this);

        BnUpdate = view.findViewById(R.id.bn_update_user);
        BnUpdate.setOnClickListener(this);

        return view;
    }

//    use case break to set diff conditions for onclick method
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bn_add_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddUserFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.bn_view_users:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ReadUserFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.bn_delete_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteUserFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.bn_update_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }
}
