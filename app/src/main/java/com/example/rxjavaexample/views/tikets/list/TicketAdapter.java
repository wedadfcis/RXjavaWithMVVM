package com.example.rxjavaexample.views.tikets.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rxjavaexample.R;
import com.example.rxjavaexample.helper.ImageLoader;
import com.example.rxjavaexample.models.dto.Ticket;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {


    Context context;
    private List<Ticket> tickets;

    public TicketAdapter(Context context) {
        this.context = context;
        tickets = new ArrayList<>();
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
        notifyItemRangeInserted(0, tickets.size());
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_ticket, viewGroup, false);
        return new TicketViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder ticketViewHolder, int i) {
        Ticket currentTicket = tickets.get(i);
        ticketViewHolder.txtTo.setText(context.getString(R.string.to) + " " + currentTicket.getTo());
        ticketViewHolder.txtFrom.setText(context.getString(R.string.from) + " " + currentTicket.getFrom());
        ticketViewHolder.txtDescription.setText(context.getString(R.string.description) + " " + currentTicket.getInstructions());
        if (!ticketViewHolder.imgLogo.equals(null) && !ticketViewHolder.imgLogo.equals("")) {
            ImageLoader.loadImage(ticketViewHolder.imgLogo, currentTicket.getAirline().getLogo());
        }
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    public class TicketViewHolder extends RecyclerView.ViewHolder {
        private TextView txtFrom;
        private TextView txtTo;
        private TextView txtDescription;
        private ImageView imgLogo;

        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            txtFrom = itemView.findViewById(R.id.txtFrom);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtTo = itemView.findViewById(R.id.txtTo);
            imgLogo = itemView.findViewById(R.id.imgLogo);
        }
    }
}
