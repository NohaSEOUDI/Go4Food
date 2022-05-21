package fr.nohas.go4food.client.interfaces;

import java.util.ArrayList;

import fr.nohas.go4food.Adaptor.HomeVerAdapter;
import fr.nohas.go4food.client.models.HomeVerModel;

public interface UpdateVerticalRec {
     void callBack(int position, ArrayList<HomeVerModel> list);
}
