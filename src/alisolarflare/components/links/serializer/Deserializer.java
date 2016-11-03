package alisolarflare.components.links.serializer;


import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import alisolarflare.components.links.entities.Link;

/**
 * @deprecated
 * @author Alisolarflare
 *
 */
public class Deserializer{

	public static void main (String args[]) {

		//Deserializer deserializer = new Deserializer();
		//List<Link> aliLink = deserializer.loadLink(aliLink);
		//System.out.println(aliLink);
	}
	
	/**@deprecated*/
	@SuppressWarnings("unchecked")
	public List<Link> loadLinkList(){
		List<Link> aliLinkList;
		try{

			FileInputStream fin = new FileInputStream("AliLinkList.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			aliLinkList = (List<Link>) ois.readObject();
			ois.close();

			return aliLinkList;

		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}