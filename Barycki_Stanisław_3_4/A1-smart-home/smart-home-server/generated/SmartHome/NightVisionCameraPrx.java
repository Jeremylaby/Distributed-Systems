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

public interface NightVisionCameraPrx extends CameraPrx
{
    default void enableNightVision()
        throws DeviceError
    {
        enableNightVision(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void enableNightVision(java.util.Map<String, String> context)
        throws DeviceError
    {
        try
        {
            _iceI_enableNightVisionAsync(context, true).waitForResponseOrUserEx();
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

    default java.util.concurrent.CompletableFuture<Void> enableNightVisionAsync()
    {
        return _iceI_enableNightVisionAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> enableNightVisionAsync(java.util.Map<String, String> context)
    {
        return _iceI_enableNightVisionAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_enableNightVisionAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "enableNightVision", null, sync, _iceE_enableNightVision);
        f.invoke(true, context, null, null, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_enableNightVision =
    {
        DeviceError.class
    };

    default void disableNightVision()
        throws DeviceError
    {
        disableNightVision(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void disableNightVision(java.util.Map<String, String> context)
        throws DeviceError
    {
        try
        {
            _iceI_disableNightVisionAsync(context, true).waitForResponseOrUserEx();
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

    default java.util.concurrent.CompletableFuture<Void> disableNightVisionAsync()
    {
        return _iceI_disableNightVisionAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> disableNightVisionAsync(java.util.Map<String, String> context)
    {
        return _iceI_disableNightVisionAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_disableNightVisionAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "disableNightVision", null, sync, _iceE_disableNightVision);
        f.invoke(true, context, null, null, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_disableNightVision =
    {
        DeviceError.class
    };

    default boolean isNightVisionEnabled()
        throws DeviceError
    {
        return isNightVisionEnabled(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean isNightVisionEnabled(java.util.Map<String, String> context)
        throws DeviceError
    {
        try
        {
            return _iceI_isNightVisionEnabledAsync(context, true).waitForResponseOrUserEx();
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

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> isNightVisionEnabledAsync()
    {
        return _iceI_isNightVisionEnabledAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> isNightVisionEnabledAsync(java.util.Map<String, String> context)
    {
        return _iceI_isNightVisionEnabledAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_isNightVisionEnabledAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "isNightVisionEnabled", null, sync, _iceE_isNightVisionEnabled);
        f.invoke(true, context, null, null, istr -> {
                     boolean ret;
                     ret = istr.readBool();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_isNightVisionEnabled =
    {
        DeviceError.class
    };

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static NightVisionCameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), NightVisionCameraPrx.class, _NightVisionCameraPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static NightVisionCameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), NightVisionCameraPrx.class, _NightVisionCameraPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static NightVisionCameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), NightVisionCameraPrx.class, _NightVisionCameraPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static NightVisionCameraPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), NightVisionCameraPrx.class, _NightVisionCameraPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static NightVisionCameraPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, NightVisionCameraPrx.class, _NightVisionCameraPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static NightVisionCameraPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, NightVisionCameraPrx.class, _NightVisionCameraPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default NightVisionCameraPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (NightVisionCameraPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default NightVisionCameraPrx ice_adapterId(String newAdapterId)
    {
        return (NightVisionCameraPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default NightVisionCameraPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (NightVisionCameraPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default NightVisionCameraPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (NightVisionCameraPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default NightVisionCameraPrx ice_invocationTimeout(int newTimeout)
    {
        return (NightVisionCameraPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default NightVisionCameraPrx ice_connectionCached(boolean newCache)
    {
        return (NightVisionCameraPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default NightVisionCameraPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (NightVisionCameraPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default NightVisionCameraPrx ice_secure(boolean b)
    {
        return (NightVisionCameraPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default NightVisionCameraPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (NightVisionCameraPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default NightVisionCameraPrx ice_preferSecure(boolean b)
    {
        return (NightVisionCameraPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default NightVisionCameraPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (NightVisionCameraPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default NightVisionCameraPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (NightVisionCameraPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default NightVisionCameraPrx ice_collocationOptimized(boolean b)
    {
        return (NightVisionCameraPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default NightVisionCameraPrx ice_twoway()
    {
        return (NightVisionCameraPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default NightVisionCameraPrx ice_oneway()
    {
        return (NightVisionCameraPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default NightVisionCameraPrx ice_batchOneway()
    {
        return (NightVisionCameraPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default NightVisionCameraPrx ice_datagram()
    {
        return (NightVisionCameraPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default NightVisionCameraPrx ice_batchDatagram()
    {
        return (NightVisionCameraPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default NightVisionCameraPrx ice_compress(boolean co)
    {
        return (NightVisionCameraPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default NightVisionCameraPrx ice_timeout(int t)
    {
        return (NightVisionCameraPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default NightVisionCameraPrx ice_connectionId(String connectionId)
    {
        return (NightVisionCameraPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default NightVisionCameraPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (NightVisionCameraPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::SmartHome::NightVisionCamera";
    }
}
