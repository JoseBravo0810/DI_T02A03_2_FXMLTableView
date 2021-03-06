/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmltableview;

import java.text.Format;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

/**
 *
 * @author jose
 */

// Clase para darle formato a la tabla (celdas), implementa funcion callback
public class FormattedTableCellFactory<S, T> 
    implements Callback<TableColumn<S, T>, TableCell<S, T>> {
    
    // Atributos
    private TextAlignment alignment;
    private Format format;
 
    // Setter y getters
    public TextAlignment getAlignment() {
        return alignment;
    }
 
    public void setAlignment(TextAlignment alignment) {
        this.alignment = alignment;
    }
 
    public Format getFormat() {
        return format;
    }
 
    public void setFormat(Format format) {
        this.format = format;
    }
    
    // Sobreescribimos el metodo abstracto de la clase implementada
    @Override
    @SuppressWarnings("unchecked")
    public TableCell<S, T> call(TableColumn<S, T> p) {
        TableCell<S, T> cell = new TableCell<S, T>() {
            @Override
            public void updateItem(Object item, boolean empty) {
                if (item == getItem()) {
                    return;
                }
                super.updateItem((T) item, empty);
                if (item == null) {
                    super.setText(null);
                    super.setGraphic(null);
                } else if (format != null) {
                    super.setText(format.format(item));
                } else if (item instanceof Node) {
                    super.setText(null);
                    super.setGraphic((Node) item);
                } else {
                    super.setText(item.toString());
                    super.setGraphic(null);
                }
            }
        };
        
        // Alineamos el texto de las celdas
        cell.setTextAlignment(alignment);
        switch (alignment) {
            case CENTER:
                cell.setAlignment(Pos.CENTER);
                break;
            case RIGHT:
                cell.setAlignment(Pos.CENTER_RIGHT);
                break;
            default:
                cell.setAlignment(Pos.CENTER_LEFT);
                break;
        }
        return cell;
    }
}



