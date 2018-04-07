package com.example.focus.listapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    public ContactAdapter(ArrayList<Contact> contacts){
            this.contacts = contacts;
    }

    ArrayList<Contact> contacts = new ArrayList<Contact>();

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        ContactViewHolder contactViewHolder= new ContactViewHolder(view);

        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        Contact CON = contacts.get(position);
        holder.projectImage.setImageResource(CON.getImage_id());
        holder.projectName.setText(CON.getName());
        holder.projectShortDescription.setText(CON.getShortDescription());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        ImageView projectImage;
        TextView projectName, projectShortDescription;

        public ContactViewHolder(View view){
            super(view);
            projectImage = view.findViewById(R.id.project_image);
            projectName = view.findViewById(R.id.project_name);
            projectShortDescription = view.findViewById(R.id.project_short_description);
        }
    }
}
