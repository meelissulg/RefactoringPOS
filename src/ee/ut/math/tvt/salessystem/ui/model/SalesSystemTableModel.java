package ee.ut.math.tvt.salessystem.ui.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.table.AbstractTableModel;

import ee.ut.math.tvt.salessystem.domain.data.DisplayableItem;

/**
 * Generic table model implementation suitable for extending.
 */
public abstract class SalesSystemTableModel<T extends DisplayableItem> extends
        AbstractTableModel {

    private static final long serialVersionUID = 1L;

    //protected List<T> rows;
    protected final String[] headers;

    public SalesSystemTableModel(final String[] headers) {
        this.headers = headers;
        //rows = new ArrayList<T>();
    }

    /**
     * @param item
     *            item describing selected row
     * @param columnIndex
     *            selected column index
     * @return value displayed in column with specified index
     */
    protected abstract Object getColumnValue(T item, int columnIndex);

    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        return headers[columnIndex];
    }

    public int getRowCount() {
    	//muutus
        return getTableRows().size();
    }

    public Object getValueAt(final int rowIndex, final int columnIndex) {
        //muutus
    	return getColumnValue(getTableRows().get(rowIndex), columnIndex);
    }
    
    // search for item with the specified id
    public T getItemById(final long id) {
    	//muutus
        for (final T item : getTableRows()) {
            if (item.getId() == id)
                return item;
        }
        throw new NoSuchElementException();
    }
    // tehtud abstraktseks
    abstract public List<T> getTableRows();
//??
    public void clear() {
        //rows = new ArrayList<T>();
        fireTableDataChanged();
   }
//++
    public void populateWithData(final List<T> data) {
    	//muutus
        getTableRows().clear();
        getTableRows().addAll(data);
    }
    
    public void addRow(T row) {
    	//muutus
        getTableRows().add(row);
        fireTableDataChanged();
    }
    
    public T getRow(int index) {
    	//muutus
        return getTableRows().get(index);
    }
    
    //??
    //public List<T> getRows() {
      //  return rows;
    //}
    
}
