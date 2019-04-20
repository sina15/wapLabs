import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class customTag extends SimpleTagSupport {

    private  String color;
    private String size;
    private Date date = new Date();
    private SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        if(color==null&& size!=null){
            out.println("<span style='font-size:"+size+"'>Current Date: "+ft.format(date)+"</span>");
        }else if(color!=null &&size==null){
            out.println("<span style='color:"+color+";'>Current Date: "+ft.format(date)+"</span>");
        }else if(color==null && size ==null){
            out.println("<span >Current Date: "+ft.format(date)+"</span>");
        }else{
            out.println("<span style='color:"+color+";font-size:"+size+"'>Current Date: "+ft.format(date)+"</span>");
        }

    }


    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Date getDate() {

        return date;
    }
}
