package eu.ilanko.digitalxpplatform.android.api.model;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import android.os.Parcelable;
public interface Node extends Serializable, Parcelable
{

    // ////////////////////////////////////////////////////
    // Shortcut and common methods
    // ////////////////////////////////////////////////////
    /**
     * Returns unique identifier of the node.
     *
     * @return the identifier
     */
    String getIdentifier();

    /**
     * Returns the name of the node.
     *
     * @return the name
     */
    String getName();

    /**
     * Returns the title of the Node.
     *
     * @return the title
     */
    String getTitle();

    /**
     * Returns the description of the Node.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Returns the type of this Node. <br/>
     *
     * @return By default
     *         {@link org.Ilanko.mobile.android.api.constants.ContentModel#TYPE_CONTENT
     *         TYPE_CONTENT} in document case or
     *         {@link org.Ilanko.mobile.android.api.constants.ContentModel#TYPE_FOLDER
     *         TYPE_FOLDER} in folder case.<br/>
     *         In other cases it returns the specific custom type like
     *         my:customdoc
     */
    String getType();

    /**
     * Returns the username of the person who created the node.
     *
     * @return the created by
     */
    String getCreatedBy();

    /**
     * Returns the timestamp in the session’s locale when the node was created.
     *
     * @return the created at
     */
    GregorianCalendar getCreatedAt();

    /**
     * Returns the username of the person who modified the node.
     *
     * @return the modified by
     */
    String getModifiedBy();

    /**
     * Gets the modified at.
     *
     * @return Returns the timestamp in the session’s locale when the node was
     *         modified.
     */
    GregorianCalendar getModifiedAt();

    // ////////////////////////////////////////////////////
    // Properties and Aspects
    // ////////////////////////////////////////////////////

    /**
     * Returns the requested property. Use this methods if your property is a
     * multi-value
     *
     * @param name : unique identifier of your property.
     * @return Property object.
     */
    Property getProperty(String name);

    /**
     * Returns a Map of all available properties for the specific node object. <br>
     * NB : All property id are CMIS based.
     *
     * @return map of properties object
     */
    Map<String, Property> getProperties();

    /**
     * Returns the value of the property with the given name.
     *
     * @param name : unique identifier label of the property
     * @return the property value
     */
    <T> T getPropertyValue(String name);

    /**
     * Determines if the node has the specified aspect.
     *
     * @param aspectName : unique identifier of aspect Name.
     * @return true if the specified aspect is present, false otherwise
     */
    boolean hasAspect(String aspectName);

    /**
     * Returns all the aspects applied to the node.
     *
     * @return the aspects
     */
    List<String> getAspects();

    /**
     * Indicates whether the node has all it’s metadata populated.
     *
     * @return true if all properties are present. False if only general metadata
     *         are provided.
     * @since 1.2
     */
    boolean hasAllProperties();

    // ////////////////////////////////////////////////////
    // Types
    // ////////////////////////////////////////////////////

    /**
     * Return true if this instance represents a folder, false if this
     * represents a document.
     *
     * @return true, if is folder
     */
    boolean isFolder();

    /**
     * Return true if this instance represents a document, false if this
     * represents a folder.
     *
     * @return true, if is document
     */
    boolean isDocument();
}

