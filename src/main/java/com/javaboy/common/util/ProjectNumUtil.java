package com.javaboy.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: zyf
 * @create: 2021-09-18 12:29
 **/
public class ProjectNumUtil {
    protected File root;
    protected int lineCounter;

    public void Dir(String rootname)
    {
        if (rootname.charAt(rootname.length() - 1) != File.separatorChar) {
            rootname = rootname + File.separator;
        }
        root = new File(rootname);
    }

    public void countLine()
    {
        lineCounter = 0;
        recurrent(root);
    }

    public int getLines()
    {
        return lineCounter;
    }

    protected void recurrent(File root)
    {
        if (root != null)
        {
            String sroot = root.getAbsolutePath();
            String[] tmp = sroot.split("\\\\");

            String filename = tmp[tmp.length - 1];
            if (root.isDirectory())
            {
                File[] fileArray = root.listFiles();
                for (File fa : fileArray)
                {
                    recurrent(fa);
                }
            } else
            {
                if (filename.contains(".java")) {
                    try {
                        BufferedReader fin = new BufferedReader(new FileReader(root));
                        while (fin.readLine() != null)
                        {
                            lineCounter++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(filename);
            }
        }
    }

    public static void main(String[] args) {
        ProjectNumUtil cl = new ProjectNumUtil();
        cl.Dir("D:\\IDEA\\360\\two\\alltesting_zz\\src");
        cl.countLine();
        System.out.println(cl.getLines());

    }

}
