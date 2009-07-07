/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tor.tribes.types;

import de.tor.tribes.util.xml.JaxenUtils;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;

/**
 *
 * @author Jejkal
 */
public class Note {

    private String sNoteText = null;
    private List<Integer> villageIds = null;
    private long timestamp = -1;
    private int mapMarker = 0;

    public Note() {
        villageIds = new LinkedList<Integer>();
        setTimestamp(System.currentTimeMillis());
        sNoteText = "";
    }

    public static Note fromXml(Element e) throws Exception {
        Note n = new Note();
        n.setTimestamp(Long.parseLong(e.getChild("timestamp").getText()));
        n.setMapMarker(Integer.parseInt(e.getChild("mapMarker").getText()));
        n.setNoteText(URLDecoder.decode(e.getChild("text").getText(), "UTF-8"));
        for (Element elem : (List<Element>) JaxenUtils.getNodes(e, "villages/village")) {
            n.getVillageIds().add(Integer.parseInt(elem.getValue()));
        }
        return n;
    }

    public String toXml() throws Exception {
        String result = "<note>\n";
        result += "<timestamp>" + getTimestamp() + "</timestamp>\n";
        result += "<mapMarker>" + getMapMarker() + "</mapMarker>\n";
        result += "<text>" + URLEncoder.encode(getNoteText(), "UTF-8") + "</text>\n";
        result += "<villages>\n";
        for (Integer id : getVillageIds()) {
            result += "<village>" + id + "</village>\n";
        }
        result += "</villages>\n";
        result += "</note>\n";
        return result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long pValue) {
        timestamp = pValue;
    }

    public void setNoteText(String pText) {

        if (sNoteText != null) {
            if (!sNoteText.equals(pText)) {
                sNoteText = pText;
                setTimestamp(System.currentTimeMillis());
            }
        } else {
            sNoteText = pText;
            setTimestamp(System.currentTimeMillis());
        }
    }

    public String getNoteText() {
        if (sNoteText == null) {
            return "";
        } else {
            return sNoteText;
        }
    }

    public static void main(String[] args) throws Exception {
        String note = "<notes><note><timestamp>10001232</timestamp><text>MeinText</text></note></notes>";
        Document d = JaxenUtils.getDocument(note);
    }

    /**
     * @return the villageIds
     */
    public List<Integer> getVillageIds() {
        return villageIds;
    }

    public boolean addVillage(Village v) {
        if (villageIds.contains(v.getId())) {
            return false;
        }
        villageIds.add(v.getId());
        setTimestamp(System.currentTimeMillis());
        return true;
    }

    public void removeVillage(Village v) {
        villageIds.remove((Integer) v.getId());
        setTimestamp(System.currentTimeMillis());
    }

    /**
     * @param villageIds the villageIds to set
     */
    public void setVillageIds(List<Integer> villageIds) {
        this.villageIds = villageIds;
    }

    /**
     * @return the mapMarker
     */
    public int getMapMarker() {
        return mapMarker;
    }

    /**
     * @param mapMarker the mapMarker to set
     */
    public void setMapMarker(int mapMarker) {
        this.mapMarker = mapMarker;
    }
}