//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.10
//
// <auto-generated>
//
// Generated from file `SmartHome.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SmartHome;

public interface CameraPrx extends DevicePrx
{
    default void move(Position pos)
        throws DeviceError,
               InvalidParameterError
    {
        move(pos, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void move(Position pos, java.util.Map<String, String> context)
        throws DeviceError,
               InvalidParameterError
    {
        try
        {
            _iceI_moveAsync(pos, context, true).waitForResponseOrUserEx();
        }
        catch(DeviceError ex)
        {
            throw ex;
        }
        catch(InvalidParameterError ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> moveAsync(Position pos)
    {
        return _iceI_moveAsync(pos, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> moveAsync(Position pos, java.util.Map<String, String> context)
    {
        return _iceI_moveAsync(pos, context, false);
    }

    /**
     * @hidden
     * @param iceP_pos -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_moveAsync(Position iceP_pos, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "move", null, sync, _iceE_move);
        f.invoke(true, context, null, ostr -> {
                     Position.ice_write(ostr, iceP_pos);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_move =
    {
        DeviceError.class,
        InvalidParameterError.class
    };

    default Position getPosition()
        throws DeviceError
    {
        return getPosition(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Position getPosition(java.util.Map<String, String> context)
        throws DeviceError
    {
        try
        {
            return _iceI_getPositionAsync(context, true).waitForResponseOrUserEx();
        }
        catch(DeviceError ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Position> getPositionAsync()
    {
        return _iceI_getPositionAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Position> getPositionAsync(java.util.Map<String, String> context)
    {
        return _iceI_getPositionAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Position> _iceI_getPositionAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Position> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getPosition", null, sync, _iceE_getPosition);
        f.invoke(true, context, null, null, istr -> {
                     Position ret;
                     ret = Position.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_getPosition =
    {
        DeviceError.class
    };

    default void setZoom(ZoomLevel zoom)
        throws DeviceError,
               InvalidParameterError
    {
        setZoom(zoom, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void setZoom(ZoomLevel zoom, java.util.Map<String, String> context)
        throws DeviceError,
               InvalidParameterError
    {
        try
        {
            _iceI_setZoomAsync(zoom, context, true).waitForResponseOrUserEx();
        }
        catch(DeviceError ex)
        {
            throw ex;
        }
        catch(InvalidParameterError ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<Void> setZoomAsync(ZoomLevel zoom)
    {
        return _iceI_setZoomAsync(zoom, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> setZoomAsync(ZoomLevel zoom, java.util.Map<String, String> context)
    {
        return _iceI_setZoomAsync(zoom, context, false);
    }

    /**
     * @hidden
     * @param iceP_zoom -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_setZoomAsync(ZoomLevel iceP_zoom, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "setZoom", null, sync, _iceE_setZoom);
        f.invoke(true, context, null, ostr -> {
                     ZoomLevel.ice_write(ostr, iceP_zoom);
                 }, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_setZoom =
    {
        DeviceError.class,
        InvalidParameterError.class
    };

    default ZoomLevel getZoom()
        throws DeviceError
    {
        return getZoom(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default ZoomLevel getZoom(java.util.Map<String, String> context)
        throws DeviceError
    {
        try
        {
            return _iceI_getZoomAsync(context, true).waitForResponseOrUserEx();
        }
        catch(DeviceError ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<ZoomLevel> getZoomAsync()
    {
        return _iceI_getZoomAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<ZoomLevel> getZoomAsync(java.util.Map<String, String> context)
    {
        return _iceI_getZoomAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<ZoomLevel> _iceI_getZoomAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<ZoomLevel> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getZoom", null, sync, _iceE_getZoom);
        f.invoke(true, context, null, null, istr -> {
                     ZoomLevel ret;
                     ret = ZoomLevel.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_getZoom =
    {
        DeviceError.class
    };

    default CameraSettings getCameraSettings()
        throws DeviceError
    {
        return getCameraSettings(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default CameraSettings getCameraSettings(java.util.Map<String, String> context)
        throws DeviceError
    {
        try
        {
            return _iceI_getCameraSettingsAsync(context, true).waitForResponseOrUserEx();
        }
        catch(DeviceError ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<CameraSettings> getCameraSettingsAsync()
    {
        return _iceI_getCameraSettingsAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<CameraSettings> getCameraSettingsAsync(java.util.Map<String, String> context)
    {
        return _iceI_getCameraSettingsAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<CameraSettings> _iceI_getCameraSettingsAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<CameraSettings> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getCameraSettings", null, sync, _iceE_getCameraSettings);
        f.invoke(true, context, null, null, istr -> {
                     CameraSettings ret;
                     ret = CameraSettings.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_getCameraSettings =
    {
        DeviceError.class
    };

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static CameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static CameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static CameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static CameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static CameraPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static CameraPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, CameraPrx.class, _CameraPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default CameraPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (CameraPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default CameraPrx ice_adapterId(String newAdapterId)
    {
        return (CameraPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default CameraPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (CameraPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default CameraPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (CameraPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default CameraPrx ice_invocationTimeout(int newTimeout)
    {
        return (CameraPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default CameraPrx ice_connectionCached(boolean newCache)
    {
        return (CameraPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default CameraPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (CameraPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default CameraPrx ice_secure(boolean b)
    {
        return (CameraPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default CameraPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (CameraPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default CameraPrx ice_preferSecure(boolean b)
    {
        return (CameraPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default CameraPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (CameraPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default CameraPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (CameraPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default CameraPrx ice_collocationOptimized(boolean b)
    {
        return (CameraPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default CameraPrx ice_twoway()
    {
        return (CameraPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default CameraPrx ice_oneway()
    {
        return (CameraPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default CameraPrx ice_batchOneway()
    {
        return (CameraPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default CameraPrx ice_datagram()
    {
        return (CameraPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default CameraPrx ice_batchDatagram()
    {
        return (CameraPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default CameraPrx ice_compress(boolean co)
    {
        return (CameraPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default CameraPrx ice_timeout(int t)
    {
        return (CameraPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default CameraPrx ice_connectionId(String connectionId)
    {
        return (CameraPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default CameraPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (CameraPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::SmartHome::Camera";
    }
}
