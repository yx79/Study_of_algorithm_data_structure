//
//  StreetLegal.h
//  StreetLegal
//
//  Any objcts that adopt this protocol are guaranteed to implement all of the above methods. The <NSObject> after the protocol name incorporates the NSObject protocol (not to be confused with the NSObject class) into the StreetLegal protocol.
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>

@protocol StreetLegal <NSObject>

- (void)signalStop;
- (void)signalLeftTurn;
- (void)signalRightTurn;

@end
