package com.spiderg.listeners;


/*
 *   Listener which declares the callback when the asset file has been loaded
 */
public interface IFileLoadedListener
{
    // Callback raised when the file was loaded successfully...
    public abstract void onFileLoadSuccess(String response);

    // Callback raised when the file failed to load...
    public abstract void onFileLoadError(String error);
}
