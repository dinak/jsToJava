package com.run;

import com.parser.Parser;

/**
 * Created by damatya on 9/19/17.
 */
public class Main {
    public static void main(String[] args) {
        String data = "VDLG.WA/I1TKRT/E1RTDP/P0735VGYAUNB+IATB:1+TK0AV+1APPC+141104:1059+0903D10902BDE4+0903D10902BDE4'UNH+1+PAOREQ:99:0:IA+1PHDQA4C07B05SEP1008'MSG+1:46'ORG+1P:HDQ+91224210:OHP+LON+1P+T+GB+GS'ODI+DXB+LON'TVL+300916:0315:300916:0730+DXB+SAW+TK+0759+1+1+P'ECH+NCUTVZ/91224210/OHP'LEG+DXB+SAW+C:16+Y:85'EQI+C'CLS+C+0:16:998'CLS+D+0:16:998'CLS+Z+0:16:998'CLS+K+0:16:998'CLS+J+0:16:998'CLS+I+0:9:998'CLS+R+0:9:998'EQI+Y'CLS+Y+0:85:998'CLS+B+0:85:998'CLS+M+0:84:998'CLS+A+0:82:998'CLS+H+0:81:998'CLS+S+0:80:998'CLS+O+0:77:998'CLS+E+0:75:998'CLS+Q+0:71:998'CLS+T+1:65:0'CLS+L+2:56:0'CLS+V+0:46:0'CLS+P+1:45:0'CLS+W+51:41:0'CLS+U+0:31:0'CLS+X+0:29:998'CLS+N+0:9:998'CLS+G+0:0:998'TVL+300916:0835:300916:1040+SAW+LGW+TK+1963+1+2+P'ECH+NCUTVZ/91224210/OHP'LEG+SAW+LGW+C:16+Y:127'EQI+C'CLS+C+0:16:998'CLS+D+0:16:998'CLS+Z+0:16:998'CLS+K+0:15:998'CLS+J+0:7:998'CLS+I+0:5:998'CLS+R+0:2:998'EQI+Y'CLS+Y+0:127:998'CLS+B+0:127:998'CLS+M+0:126:998'CLS+A+0:126:998'CLS+H+0:125:998'CLS+S+0:123:998'CLS+O+0:123:998'CLS+E+0:120:998'CLS+Q+0:114:998'CLS+T+0:109:0'CLS+L+0:105:0'CLS+V+0:97:0'CLS+P+0:88:0'CLS+W+16:83:0'CLS+U+1:56:0'CLS+X+0:50:998'CLS+N+0:49:998'CLS+G+0:0:998'TVL+300916:0655:300916:1045+DXB+IST+TK+0763+2+3+P'ECH+NCUTVZ/91224210/OHP'LEG+DXB+IST+C:46+Y:237'EQI+C'CLS+C+0:46:998'CLS+D+0:44:998'CLS+Z+0:42:998'CLS+K+0:39:998'CLS+J+3:35:998'CLS+I+0:19:998'CLS+R+0:18:998'EQI+Y'CLS+Y+0:237:998'CLS+B+0:229:998'CLS+M+5:225:998'CLS+A+0:225:998'CLS+H+0:221:998'CLS+S+0:214:998'CLS+O+0:202:998'CLS+E+2:190:998'CLS+Q+1:179:998'CLS+T+9:151:0'CLS+L+7:134:0'CLS+V+8:102:0'CLS+P+7:97:0'CLS+W+35:92:0'CLS+U+4:72:0'CLS+X+0:57:998'CLS+N+0:20:998'CLS+G+0:0:998'TVL+300916:1255:300916:1500+IST+LHR+TK+1985+2+4+P'ECH+NCUTVZ/91224210/OHP'LEG+IST+LHR+C:45+Y:211'EQI+C'CLS+C+0:45:998'CLS+D+0:38:998'CLS+Z+0:34:998'CLS+K+2:30:998'CLS+J+2:20:998'CLS+I+0:14:998'CLS+R+0:0:998'EQI+Y'CLS+Y+0:211:998'CLS+B+0:200:998'CLS+M+0:192:998'CLS+A+0:186:998'CLS+H+1:180:998'CLS+S+2:161:998'CLS+O+0:153:998'CLS+E+0:142:998'CLS+Q+1:120:998'CLS+T+0:109:0'CLS+L+5:107:0'CLS+V+8:104:0'CLS+P+5:99:0'CLS+W+72:88:0'CLS+U+5:14:0'CLS+X+2:0:998'CLS+N+0:0:998'CLS+G+0:0:998'UNT+125+1'";

        Parser parser = new Parser(data);
        parser.parse();


    }
}
