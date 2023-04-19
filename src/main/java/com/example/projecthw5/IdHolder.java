package com.example.projecthw5;

// ця структура для зберігання id, який ми можемо показати клієнту після того, як він додав цитату quote класу Quote

public class IdHolder
{
    public IdHolder(int id)
    {

        this.id = id;
    }

    public int getId()
    {

        return id;
    }

    public void setId(int id)
    {

        this.id = id;
    }

    private int id;
}
