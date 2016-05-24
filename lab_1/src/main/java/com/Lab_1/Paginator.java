package com.Lab_1;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Paginator {
    public ArrayList<Integer> getList(int currentPage, int countPages) {
        ArrayList <Integer> slidePart = new ArrayList<Integer>();
        ArrayList <Integer> result = new ArrayList<Integer>();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the width of the paginator: ");
        int wigth = input.nextInt();


        if (currentPage > countPages) {
            currentPage = countPages;
        } else {
            if (currentPage < 1) {
                currentPage = 1;
            }
        }

        if (countPages > 0) {

            int element = currentPage - wigth/2;

            for (int i = 0; i < wigth; ++i){
                if (element > 0 && element < countPages){
                    slidePart.add(element);
                }
                element++;
            }

            Integer slideSize = slidePart.size() - 1;

            result.addAll(slidePart);

            if ((slidePart.get(0)) != 1) {
                result.add(0, 1);
            }

            if ((slidePart.get(0)) > 2) {
                result.add(1, 0);
            }

            if ((slidePart.get(slideSize)) != countPages) {
                result.add(countPages);
            }

            if ((countPages - (slidePart.get(slideSize))) > 1) {
                result.add((result.size() - 1), 0);
            }
        }
        return result;
    }
    public String html(int currentPage, int countPages) {

        ArrayList <Integer> listNumbers = this.getList(currentPage, countPages);

        String html = "<html><head><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css'>	<meta charset='UTF-8'></head><body>";

        html += "<ul class = 'pagination'>";

        String link = "";

        for (Integer page : listNumbers) {
            if (page == 0) {
                link = "<li> ... </li>";
            }
            else if (page == currentPage) {
                link = String.format(
                        "<li class = 'active'><a href = '#!'>%1$d</a></li>", page
                );
            } else {
                link = String.format(
                        "<li class = 'waves-effect'><a href = 'page%1$d'>%1$d</a></li>", page
                );
            }
            html += "&nbsp;" + link;
        }


        html += "</ul>";

        html += "</body></html>";

        return html;
    }
}
