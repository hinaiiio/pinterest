import com.fasterxml.jackson.core.type.TypeReference;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

/**
 * Created by hina on 2017/01/11.
 */
public class Myform extends JFrame implements ActionListener {

    private JPanel panel1;
    private JButton ohituji;
    private JButton oushi;
    private JButton futago;
    private JButton kani;
    private JButton shishi;
    private JButton otome;
    private JButton tenbin;
    private JButton sasori;
    private JButton ite;
    private JButton yagi;
    private JButton mizugame;
    private JButton uo;

    private JPanel imagePane;
    private ImageIcon icon;
    private JLabel label;
    private JScrollBar scrollBar1;

    String stringurl = "";
    URL url;

    public Myform() {


//        ohituji.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                stringurl = "http://www.javadrive.jp/tutorial/imageicon/hasami.png";
//                createUIComponents();
//                System.out.println(stringurl);
//                repaint();
//            }
//        });


//        ohituji.addActionListener(this);
//        ohituji.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                stringurl = "http://www.javadrive.jp/tutorial/imageicon/hasami.png";
//                try {
//                    //Load another image from internet.
//                    url = new URL(stringurl);
//                    BufferedImage img = ImageIO.read(url);
////                    icon.setImage(img);
//                    icon = new ImageIcon("93987f51.jpg");
//                    label = new JLabel(icon);
////                    label.setIcon(icon);
//                    repaint();
//                    System.out.println("flg22");
//                } catch (MalformedInputException E) {
//                    E.printStackTrace();
//                } catch (IOException E) {
//                    E.printStackTrace();
//                }
//
//            }
//        });
        ohituji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringurl = "http://www.javadrive.jp/tutorial/imageicon/hasami.png";
                try {
                    System.out.println("flg");
                    //Load another image from internet.
                    url = new URL(stringurl);
                    BufferedImage img = ImageIO.read(url);
                    icon.setImage(img);
//            icon = new ImageIcon(url);
//            label = new JLabel(icon);
                    label.setIcon(icon);
                    repaint();
                } catch (MalformedInputException E) {
                    E.printStackTrace();
                } catch (IOException E) {
                    E.printStackTrace();
                }
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        stringurl = "http://www.javadrive.jp/tutorial/imageicon/hasami.png";
        try {
            System.out.println("flg");
            //Load another image from internet.
            url = new URL(stringurl);
            BufferedImage img = ImageIO.read(url);
            icon.setImage(img);
//            icon = new ImageIcon(url);
//            label = new JLabel(icon);
            label.setIcon(icon);
            repaint();
        } catch (MalformedInputException E) {
            E.printStackTrace();
        } catch (IOException E) {
            E.printStackTrace();
        }

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        System.out.println("flgcreate");
        try{
            stringurl = "http://www.oyakudachibook.com/wp-content/uploads/2014/01/44cf4d71bf948536b4369c35badd7391.png";
            url = new URL(stringurl);
        }catch(MalformedURLException E){
            E.printStackTrace();
        }
        icon = new ImageIcon(url);
        label = new JLabel(icon);
        label.setIcon(icon);
    }

    public static void main(String[] args) throws IOException {
        GoogleImgList jsonObject = JsonConverter.toObject(new File("test.json"), new TypeReference<GoogleImgList>() {
        });

        System.out.println(jsonObject.getItems().get(2).getLink());
        System.out.println(jsonObject.getItems().get(2).getImage().getThumbnailLink());

        JFrame frame = new JFrame( "Today's Your Color" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setContentPane(new Myform().panel1);
//        frame.setContentPane(new Myform("http://www.oyakudachibook.com/wp-content/uploads/2014/01/44cf4d71bf948536b4369c35badd7391.png").imagePane);
        frame.pack();
        frame.setVisible(true);
    }



}
