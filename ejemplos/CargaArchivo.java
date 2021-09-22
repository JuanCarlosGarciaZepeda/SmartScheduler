/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uam.pvoe.sw.ev.operaciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import uam.pvoe.ws.ev.modelo.Cliente;
import uam.pvoe.ws.ev.modelo.ClienteProducto;
import uam.pvoe.ws.ev.modelo.Producto;

/**
 *
 * @author antra
 */
public class CargaArchivo {
    /*Recupera los clientes del archivo*/
    public LinkedList<Cliente> listaClientes(){
        
        LinkedList<Cliente> listaClientes = new LinkedList(); 
        
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("cliente.dat");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                Cliente cliente = new Cliente();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                
                cliente.setNumCliente(Integer.parseInt(st.nextToken()));
                cliente.setNombre(st.nextToken());
                cliente.setaPaterno(st.nextToken());
                cliente.setaMaterno(st.nextToken());
                
                listaClientes.add(cliente);
                cadenaLeida = archivoLectura.readLine();
            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }
        
        return listaClientes;
    }
    
    /*Recupera los productos del archivo*/
    public LinkedList<Producto> listaProductos(){
        
        LinkedList<Producto>listaProductos = new LinkedList();
        
        String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("productos.dat");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                
                Producto producto = new Producto();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");

                producto.setNumProducto(Integer.parseInt(st.nextToken()));
                producto.setNombreProducto(st.nextToken());
                
                listaProductos.add(producto);
                cadenaLeida = archivoLectura.readLine();
            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }
        
        return listaProductos;
        
    }
    
    /*Recupera las ventas del archivo*/
    public LinkedList<ClienteProducto>listaVentas(){
        
        LinkedList<ClienteProducto>listaVentas = new LinkedList();
        
           String cadenaLeida = "";
        FileReader fr;
        try {
            fr = new FileReader("compras_cliente_producto.dat");
            BufferedReader archivoLectura = new BufferedReader(fr);
            cadenaLeida = archivoLectura.readLine();
            while (cadenaLeida != null) {
                ClienteProducto venta = new ClienteProducto();
                StringTokenizer st = new StringTokenizer(cadenaLeida, ",");
                
                venta.setNumCliente(Integer.parseInt(st.nextToken()));
                venta.setNumProducto(Integer.parseInt(st.nextToken()));
                venta.setCantidad(Integer.parseInt(st.nextToken()));
   
                listaVentas.add(venta);
                cadenaLeida = archivoLectura.readLine();
            }
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer del archivo");
            e.printStackTrace();
        }
        
        
        return listaVentas;
        
    }
}
