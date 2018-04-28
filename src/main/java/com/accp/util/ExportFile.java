package com.accp.util;

import com.accp.entity.DealDetail;
import com.accp.entity.Type;
import com.accp.entity.UserInfo;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ExportFile {
    //导出数据为Excel
    public static void ExportExcel(String fileName ,String title, String[] headers, List<?> data) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个工作表
        HSSFSheet sheet = workbook.createSheet(title);
        //创建第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue(title);
        //遍历列名  循环添加列
        row = sheet.createRow(1);
        for (short i=0;i<headers.length; i++){
            //创建单元格
            HSSFCell columnCell = row.createCell(i);
            HSSFRichTextString columntext = new HSSFRichTextString(headers[i]);
            //为单元格赋值
            columnCell.setCellValue(columntext);
        }
        // 遍历集合数据，产生数据行
        for(int i = 0;i<data.size();i++){
            row = sheet.createRow(i+2);
            HSSFCell dataCell = null;
            //判断传入集合是否为UserInfo/DealDetail/Type 类型
            if(data.get(i) instanceof UserInfo){
                UserInfo userInfo = (UserInfo) data.get(i);
                dataCell = row.createCell((short) 0);
                dataCell.setCellValue(i+1);
                dataCell = row.createCell((short) 1);
                dataCell.setCellValue(userInfo.getUserName());
                dataCell = row.createCell((short) 2);
                dataCell.setCellValue(userInfo.getBalance());
            }else if (data.get(i) instanceof DealDetail){
                DealDetail dealDetail = (DealDetail) data.get(i);
                dataCell = row.createCell((short) 0);
                dataCell.setCellValue(i+1);
                dataCell = row.createCell((short) 1);
                dataCell.setCellValue(dealDetail.getUser().getUserName());
                dataCell = row.createCell((short) 2);
                dataCell.setCellValue(dealDetail.getFinanceFund());
                dataCell = row.createCell((short) 3);
                dataCell.setCellValue(dealDetail.getBalance());
                dataCell = row.createCell((short) 4);
                dataCell.setCellValue(dealDetail.getRemark());
                dataCell = row.createCell((short) 5);
                //创建时间日期格式
                HSSFCellStyle cellStyle = workbook.createCellStyle();
                HSSFDataFormat format= workbook.createDataFormat();
                cellStyle.setDataFormat(format.getFormat("yyyy-mm-dd"));
                dataCell.setCellStyle(cellStyle);
                dataCell.setCellValue(dealDetail.getCreateTime());
            }else{
                Type type = (Type) data.get(i);
                dataCell = row.createCell((short) 0);
                dataCell.setCellValue(i+1);
                dataCell = row.createCell((short) 1);
                dataCell.setCellValue(type.getTypeName());
                dataCell = row.createCell((short) 2);
                dataCell.setCellValue(type.getNumber());
                dataCell = row.createCell((short) 3);
                dataCell.setCellValue((type.getNumber()*type.getAllocation()));
            }
        }
        //设置输出文件位置
        FileOutputStream fout = new FileOutputStream("D:"+fileName+".xls");
        //输出打印
        workbook.write(fout);
        if(fout != null){
            fout.close();
        }
    }

    public static void ExportPDF(String fileName,String title, String[] headers, List<?> data) throws Exception {
        //创建文件
        Document document = new Document();
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("D:"+fileName+".pdf"));
        //设置字体演示
        BaseFont fontChinesecontent = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        Font chinese = new Font(fontChinesecontent, 10, Font.NORMAL);
        //打开文件
        document.open();
        //添加内容
        document.add(new Paragraph(title,chinese));
        //创建跟headers.length同等的列表格
        PdfPTable table = new PdfPTable(headers.length);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.setWidthPercentage(100); // 宽度100%填充
        table.setSpacingBefore(10f); // 前间距
        table.setSpacingAfter(10f); // 后间距
        // 循环列头
        for (int i = 0;i<headers.length;i++){
            //创建单元格
            PdfPCell columnCell = new PdfPCell();
            //设置单元格里的值  只能打印字符串类型
            Paragraph paragraph = new Paragraph(headers[i],chinese);
            columnCell.addElement(paragraph);
            //吧单元格加入到表格中
            table.addCell(columnCell);
        }
        //遍历集合,产生数据行
        for (int i= 0;i<data.size();i++){
            //判断传入集合是否为UserInfo/DealDetail/Type 类型
            if(data.get(i) instanceof UserInfo){
                UserInfo userInfo = (UserInfo) data.get(i);
                for (int j = 0;j<headers.length;j++){
                    PdfPCell dataCell = new PdfPCell();
                    if(j==0){   //设置数据航第一个单元格
                        Paragraph paragraph = new Paragraph(String.valueOf(i+1),chinese);
                        dataCell.addElement(paragraph);
                    }else if(j==1){     //设置数据行第二个单元格
                        Paragraph paragraph = new Paragraph(userInfo.getUserName(),chinese);
                        dataCell.addElement(paragraph);
                    }else{  //设置三个单元格的值
                        Paragraph paragraph = new Paragraph(String.valueOf(userInfo.getBalance()),chinese);
                        dataCell.addElement(paragraph);
                    }
                    dataCell.setVerticalAlignment(Element.ALIGN_BASELINE);  //设置单元格垂直居中
                    dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);  //设置单元格水平居中
                    table.addCell(dataCell);
                }
            }else if (data.get(i) instanceof DealDetail){
                DealDetail dealDetail = (DealDetail) data.get(i);
                for (int j = 0;j<headers.length;j++){
                    PdfPCell dataCell = new PdfPCell();
                    if(j==0){   //设置数据航第一个单元格
                        Paragraph paragraph = new Paragraph(String.valueOf(i+1),chinese);
                        dataCell.addElement(paragraph);
                    }else if(j==1){ //设置数据航第2个单元格
                        Paragraph paragraph = new Paragraph(dealDetail.getUser().getUserName(),chinese);
                        dataCell.addElement(paragraph);
                    }else if(j==2){ //设置数据航第3个单元格
                        Paragraph paragraph = new Paragraph(String.valueOf(dealDetail.getFinanceFund()),chinese);
                        dataCell.addElement(paragraph);
                    }else if(j==3){ //设置数据航第4个单元格
                        Paragraph paragraph = new Paragraph(String.valueOf(dealDetail.getBalance()),chinese);
                        dataCell.addElement(paragraph);
                    }else if(j==4){ //设置数据航第5个单元格
                        Paragraph paragraph = new Paragraph(dealDetail.getRemark(),chinese);
                        dataCell.addElement(paragraph);
                    }else { //设置数据航第6个单元格
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String format = formatter.format(dealDetail.getCreateTime());
                        Paragraph paragraph = new Paragraph(format,chinese);
                        dataCell.addElement(paragraph);
                    }
                    dataCell.setVerticalAlignment(Element.ALIGN_BASELINE);  //设置单元格垂直居中
                    dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);  //设置单元格水平居中
                    table.addCell(dataCell);
                }
            }else{
                Type type = (Type) data.get(i);
                for (int j = 0;j<headers.length;j++){
                    PdfPCell dataCell = new PdfPCell();
                    if(j==0){   //设置数据航第一个单元格
                        Paragraph paragraph = new Paragraph(String.valueOf(i+1),chinese);
                        dataCell.addElement(paragraph);
                    }else if(j==1){ //设置数据航第2个单元格
                        Paragraph paragraph = new Paragraph(type.getTypeName(),chinese);
                        dataCell.addElement(paragraph);
                    }else if(j==2){ //设置数据航第3个单元格
                        Paragraph paragraph = new Paragraph(String.valueOf(type.getNumber()),chinese);
                        dataCell.addElement(paragraph);
                    }else { //设置数据航第6个单元格
                        Paragraph paragraph = new Paragraph(String.valueOf(type.getNumber()*type.getAllocation()),chinese);
                        dataCell.addElement(paragraph);
                    }
                    dataCell.setVerticalAlignment(Element.ALIGN_BASELINE);  //设置单元格垂直居中
                    dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);  //设置单元格水平居中
                    table.addCell(dataCell);
                }
            }

        }
        //把表格添加到文件中
        document.add(table);
        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }
}
