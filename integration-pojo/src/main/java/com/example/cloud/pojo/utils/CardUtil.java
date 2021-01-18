package com.example.cloud.pojo.utils;

import java.util.*;

import com.example.cloud.pojo.entity.Card;

import lombok.Data;

/**
 *
 * Created by yangR on 2019/11/18.
 */
@Data
public class CardUtil {

    /**
     *
     * 随机打乱
     * */
    public static void wash(List<Card> list){
        Collections.shuffle(list);
    }
    public static void wash(List<Card> list, int severalTimes){
    	if (severalTimes < 1) {return;}
    	for (int i = 0; i < severalTimes; i++) {
    		Collections.shuffle(list);
		}
    }

    /**
     * 分发
     * */
    public static Map<String, List<Card>> dispense(List<Card> list){
        Map<String, List<Card>> map = new HashMap<>();
        List<Card> lista = new ArrayList<>();
        List<Card> listb = new ArrayList<>();
        List<Card> listc = new ArrayList<>();
        List<Card> lost = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
        	if (i < 50) {
        		lista.add(list.get(i));
            	i++;
            	listb.add(list.get(i));
            	i++;
            	listc.add(list.get(i));
            	continue;
			}
        	
		lost.add(list.get(i));
		}
        map.put("a", lista);
        map.put("b", listb);
        map.put("c", listc);
        map.put("lost", lost);
        return map;
    }
    
  /*  @SafeVarargs
	public static void sort(List<Card>... CardList){
    	for (List<Card> list : CardList) {
    		Collections.sort(list, new Comparator<Card>(){
    			@Override
    			public int compare(Card o1, Card o2) {
    				if (o1.getWeight_coefficient() > o2.getWeight_coefficient()) {
    					return -1;
    				}
    				return 1;
    			}});
		}
    	serial(CardList);
    }*/

}
